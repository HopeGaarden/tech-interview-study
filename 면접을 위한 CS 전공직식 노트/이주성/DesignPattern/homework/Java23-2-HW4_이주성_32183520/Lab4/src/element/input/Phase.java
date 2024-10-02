package element.input;
public enum Phase {
	gas,
	liq,
	solid,
	artificial;
	
	//get names()
	public static Phase names(String input) {
		for(Phase p : Phase.values()) {
			if (p.toString().equals(input)) {
				return p;
			}
		}

		// 일치하는 phase가 없으면 null 반환
		return null;
	}
}
