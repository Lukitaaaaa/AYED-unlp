package tp1.ejercicio3;

public class Estudiante {
	
	private String nombre = "Lucas";
	private String apellido = "Gallardo";
	private String comision = "221";
	private String email = "xxx@xxx.com";
	private String direccion = "calle xxx";
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String tusDatos() {
		String aux = this.getNombre() + "\n" + this.getApellido() + "\n" + this.getComision() + "\n" + this.getEmail() + "\n" + this.getDireccion();
		return aux;
	}
}
