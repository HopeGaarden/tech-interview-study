package element;

import element.component.Element;
import element.component.IElement;
import element.decorators.*;
import element.input.Decorator;
import element.input.UserInput;
import element.periodic.PeriodicElement;
import element.periodic.PeriodicElementImporter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {
    public MainTest() {

        // PeriodicElements.csv 파일을 load해서 PeriodicElement 리스트로 저장
        List<PeriodicElement> peList = PeriodicElementImporter.loadCSV("PeriodicElements.csv");

        // peList를 for 문으로 돌면서 번호와 이름으로 Element를 생성한 후 elementList에 add
        List<Element> eList = new ArrayList<>();
        for (PeriodicElement pe : peList) {
            eList.add(new Element(pe.getNumber(), pe.getName()));
        }

        // Element를 하나씩 뽑아서 데코레이터들로 장식 후 IElement 리스트에 추가
        List<IElement> weightAndSymbolDecoList = new ArrayList<>();
        List<IElement> allDecoList = new ArrayList<>();
        for (int i = 0; i < eList.size(); i++) {
            PeriodicElement pe = peList.get(i);
            Element e = eList.get(i);

            // WeightDecorator와 SymbolDecorator로 장식 후 리스트에 추가
            IElement ie1 = new SymbolDecorator(pe.getSymbol(), new WeightDecorator(pe.getWeight(), e));
            weightAndSymbolDecoList.add(ie1);

            // 모든 데코레이터를 사용해 장식 후 리스트에 추가
            // 순서는 SymbolDecorator, WeightDecorator, Periodecorator, GroupDecorator, PhaseDecorator, TypeDecorator 순
            IElement ie2 = new TypeDecorator(pe.getType(),
                    new PhaseDecorator(pe.getPhase(),
                            new GroupDecorator(pe.getGroup(),
                                    new PeriodDecorator(pe.getPeriod(),
                                            new WeightDecorator(pe.getWeight(),
                                                    new SymbolDecorator(pe.getSymbol(), e))))));
            allDecoList.add(ie2);
        }

        // CSV 파일로 저장
        PeriodicElementImporter.saveCSV("Elements1.csv", weightAndSymbolDecoList, "#AtomicNumber,Element,AtomicMass,Symbol");
        PeriodicElementImporter.saveCSV("Elements2.csv", allDecoList, "#AtomicNumber,Element,Symbol,AtomicMass,Periodic,Group,Phase,Type");

        // 개인적으로 추가한 코드
        // 원하는 데코레이터를 입력받아 새로운 리스트를 csv파일로 저장
        custumList(eList, peList);
    }

    private void custumList(List<Element> eList, List<PeriodicElement> peList) {
        // 원하는 데코레이터 입력받기
        List<Decorator> decorators = UserInput.getDecorators();

        // 커스텀 원소 리스트
        List<IElement> customList = new ArrayList<>();

        // Element를 하나씩 뽑아서 데코레이터들로 장식 후 IElement 리스트에 추가
        for (int i = 0; i < eList.size(); i++) {
            PeriodicElement pe = peList.get(i);
            Element e = eList.get(i);

            // IElement 장식 과정
            IElement ie = new Element(pe.getNumber(), pe.getName());
            for (Decorator d : decorators) {
                switch (d) {
                    case SymbolDecorator:
                        ie = new SymbolDecorator(pe.getSymbol(), ie);
                        break;
                    case WeightDecorator:
                        ie = new WeightDecorator(pe.getWeight(), ie);
                        break;
                    case TypeDecorator:
                        ie = new TypeDecorator(pe.getType(), ie);
                        break;
                    case PhaseDecorator:
                        ie = new PhaseDecorator(pe.getPhase(), ie);
                        break;
                    case PeriodDecorator:
                        ie = new PeriodDecorator(pe.getPeriod(), ie);
                        break;
                    case GroupDecorator:
                        ie = new GroupDecorator(pe.getGroup(), ie);
                        break;
                }
            }

            // 장식한 IElement 리스트에 추가
            customList.add(ie);
        }


        // firstLine 생성
        String firstLine = decorators.stream()
                .map(decorator -> decorator.toString().replace("Decorator", ""))
                .collect(Collectors.joining(","));

        // csv 파일로 저장
        PeriodicElementImporter.saveCSV("CustomList.csv", customList, "#AtomicNumber,Element," + firstLine);

    }
}
