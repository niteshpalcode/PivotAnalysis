package com.adjecti.entity;

public class Field {
	
	 private String name;
	    private Object value; 
	    private FieldType type;
		public Field() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Field(String name, Object value, FieldType type) {
			super();
			this.name = name;
			this.value = value;
			this.type = type;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}
		public FieldType getType() {
			return type;
		}
		public void setType(FieldType type) {
			this.type = type;
		}
	    
	    

}
