package template;

import template.finder.IPeriodicElementFinder;

import java.util.List;

public class PeriodicElementFinder {
    private IPeriodicElementFinder finder;

    // 생성자
    public PeriodicElementFinder(IPeriodicElementFinder finder) {
        this.finder = finder;
    }

    // setter
    public void setFinder(IPeriodicElementFinder finder) {
        this.finder = finder;
    }

    // find
    public void find(List<PeriodicElement> list) {
        finder.find(list);
    }
}
