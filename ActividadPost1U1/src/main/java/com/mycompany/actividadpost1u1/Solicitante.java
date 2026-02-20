package com.mycompany.actividadpost1u1;

/**
 *
 * @author tosca
 */
public class Solicitante {

    private String nombre;
    private int edad;
    private int puntajeCrediticio;
    private boolean tieneDeudas;
    private double aniosEmpleo;
    private double ingresoMensual;

    public Solicitante(String nombre, int edad, int puntajeCrediticio, boolean tieneDeudas, double aniosEmpleo, double ingresoMensual) {
        // TODO: Asignar atributos
        this.nombre = nombre;
        this.edad = edad;
        this.puntajeCrediticio = puntajeCrediticio;
        this.tieneDeudas = tieneDeudas;
        this.aniosEmpleo = aniosEmpleo;
        this.ingresoMensual = ingresoMensual;
        // TODO: Verificar invariante de clase
        verificarInvariante();
    }

    private void verificarInvariante() {
        // TODO: Implementar invariantes con assert o excepciones
        if (this.tieneDeudas){
            
        }
    }

    // getters de atributos
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getPuntajeCrediticio() {
        return puntajeCrediticio;
    }

    public boolean isTieneDeudas() {
        return tieneDeudas;
    }

    public double getAniosEmpleo() {
        return aniosEmpleo;
    }

    public double getIngresoMensual() {
        return ingresoMensual;
    }
    
    
    
}
