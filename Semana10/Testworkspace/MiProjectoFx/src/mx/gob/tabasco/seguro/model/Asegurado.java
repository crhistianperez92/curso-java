
package mx.gob.tabasco.seguro.model;

import java.io.Serializable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Asegurado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private IntegerProperty id;
	private StringProperty apellido;
	private IntegerProperty edad;
	private StringProperty nombre;
	private StringProperty numeroSeguroSocial;
	private StringProperty sexo;
	
	
	
	public Asegurado() {
		this.id = new SimpleIntegerProperty();
		this.apellido = new SimpleStringProperty();
		this.edad = new SimpleIntegerProperty();
		this.nombre = new SimpleStringProperty();
		this.numeroSeguroSocial = new SimpleStringProperty();
		this.sexo = new SimpleStringProperty();
	}
	
	public IntegerProperty idProperty() {
		return this.id;
	}
	public int getId() {
		return this.idProperty().get();
	}
	public void setId(final int id) {
		this.idProperty().set(id);
	}
	public StringProperty apellidoProperty() {
		return this.apellido;
	}
	public java.lang.String getApellido() {
		return this.apellidoProperty().get();
	}
	public void setApellido(final java.lang.String apellido) {
		this.apellidoProperty().set(apellido);
	}
	public IntegerProperty edadProperty() {
		return this.edad;
	}
	public int getEdad() {
		return this.edadProperty().get();
	}
	public void setEdad(final int edad) {
		this.edadProperty().set(edad);
	}
	public StringProperty nombreProperty() {
		return this.nombre;
	}
	public java.lang.String getNombre() {
		return this.nombreProperty().get();
	}
	public void setNombre(final java.lang.String nombre) {
		this.nombreProperty().set(nombre);
	}
	public StringProperty numeroSeguroSocialProperty() {
		return this.numeroSeguroSocial;
	}
	public java.lang.String getNumeroSeguroSocial() {
		return this.numeroSeguroSocialProperty().get();
	}
	public void setNumeroSeguroSocial(final java.lang.String numeroSeguroSocial) {
		this.numeroSeguroSocialProperty().set(numeroSeguroSocial);
	}
	public StringProperty sexoProperty() {
		return this.sexo;
	}
	public java.lang.String getSexo() {
		return this.sexoProperty().get();
	}
	public void setSexo(final java.lang.String sexo) {
		this.sexoProperty().set(sexo);
	}
	
	
	
	
	

}
