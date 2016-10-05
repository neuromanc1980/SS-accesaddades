package src;
public class Persona {

    private String DNI;
    private String NumSeguridadSocial;
    private String Nombre;
    private String Apellidos;
    private int Edad;
    private double Salario;

    public Persona(String DNI, String numSeguridadSocial, String nombre, String apellidos, int edad, double salario) {
        this.DNI = DNI;
        NumSeguridadSocial = numSeguridadSocial;
        Nombre = nombre;
        Apellidos = apellidos;
        Edad = edad;
        Salario = salario;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNumSeguridadSocial() {
        return NumSeguridadSocial;
    }

    public void setNumSeguridadSocial(String numSeguridadSocial) {
        NumSeguridadSocial = numSeguridadSocial;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double salario) {
        Salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        if (Edad != persona.Edad) return false;
        if (Double.compare(persona.Salario, Salario) != 0) return false;
        if (DNI != null ? !DNI.equals(persona.DNI) : persona.DNI != null) return false;
        if (NumSeguridadSocial != null ? !NumSeguridadSocial.equals(persona.NumSeguridadSocial) : persona.NumSeguridadSocial != null)
            return false;
        if (Nombre != null ? !Nombre.equals(persona.Nombre) : persona.Nombre != null) return false;
        return Apellidos != null ? Apellidos.equals(persona.Apellidos) : persona.Apellidos == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = DNI != null ? DNI.hashCode() : 0;
        result = 31 * result + (NumSeguridadSocial != null ? NumSeguridadSocial.hashCode() : 0);
        result = 31 * result + (Nombre != null ? Nombre.hashCode() : 0);
        result = 31 * result + (Apellidos != null ? Apellidos.hashCode() : 0);
        result = 31 * result + Edad;
        temp = Double.doubleToLongBits(Salario);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "DNI='" + DNI + '\'' +
                ", NumSeguridadSocial='" + NumSeguridadSocial + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Edad=" + Edad +
                ", Salario=" + Salario +
                '}';
    }
}

