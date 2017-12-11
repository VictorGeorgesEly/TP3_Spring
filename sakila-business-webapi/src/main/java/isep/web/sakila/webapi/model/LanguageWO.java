package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Language;

public class LanguageWO extends WebObject {

	private static final long serialVersionUID = -1819390380768696895L;

	protected byte languageId;
	protected String name;

	public LanguageWO() {
		super();
	}

	public LanguageWO(final Language language) {
		this();
		this.languageId = language.getLanguageId();
		this.name = language.getName();
	}

	public byte getLanguageId() {
		return languageId;
	}

	public void setLanguageId(byte languageId) {
		this.languageId = languageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Language [id=" + this.languageId + ", name="
				+ this.name + "]";
	}
}
