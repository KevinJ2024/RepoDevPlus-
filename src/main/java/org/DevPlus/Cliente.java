package org.DevPlus;

public class Cliente {

    private String id;
    private String nombreCompleto;
    private String razonSocial;
    private int telefono; //tipo entero porque se usa luego para operaciones
    private String correo;
    private String paisProcedencia;

    public Cliente(String id, String nombreCompleto,
                   String razonSocial, int telefono,
                   String correo, String paisProcedencia) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.correo = correo;
        this.paisProcedencia = paisProcedencia;
    }

    // Metodo para halllar si el telefono es numero perfecto
    public boolean esTelefonoPerfecto(){
        boolean esPerfecto = false;

        if(this.telefono != 0) {

            int suma = sumarDivisores();

            if (suma == this.telefono){
                esPerfecto = true;
            }
        }

        return esPerfecto;
    }

    private int sumarDivisores(){
        int acumulador = 1; // el 1 es divisor de todos
        for (int i = 2; i*i <= this.telefono; i++){
            if (this.telefono % i == 0) {
                acumulador += i;

                if(i != this.telefono / i){
                    acumulador += this.telefono / i;
                }
            }
        }

        return acumulador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }
}
