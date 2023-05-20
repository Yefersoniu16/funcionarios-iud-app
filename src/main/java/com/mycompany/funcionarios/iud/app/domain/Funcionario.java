package com.mycompany.funcionarios.iud.app.domain;

public class Funcionario {

    private int id;
    private String tipo_doccumento;
    private String numero_documento;
    private String nombre;
    private String apellido;
    private String estado_civil;
    private String sexo;
    private String direccion;
    private String telefono;
    private String fecha_nacimiento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_doccumento() {
        return tipo_doccumento;
    }

    public void setTipo_doccumento(String tipo_doccumento) {
        this.tipo_doccumento = tipo_doccumento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellidos) {
        this.apellido = apellidos;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return id + " " + nombre + " " + apellido;
    }
    // return "Funcionario{" + "id=" + id + ", tipo_doccumento=" + tipo_doccumento + ", numero_documento=" + numero_documento + ", nombre=" + nombre + ", apellidos=" + apellido + ", estado_civil=" + estado_civil + ", sexo=" + sexo + ", direccion=" + direccion + ", telefono=" + telefono + ", fecha_nacimiento=" + fecha_nacimiento + '}';

}
