package com.mycompany.actividadpost1u1;

/**
 *
 * @author tosca
 */
public class Solicitante {

    private final String nombre;
    private final int edad;
    private final int puntajeCrediticio;
    private final boolean tieneDeudas;
    private final double aniosEmpleo;
    private final double ingresoMensual;

    public Solicitante(String nombre, int edad, int puntajeCrediticio, boolean tieneDeudas, double aniosEmpleo, double ingresoMensual) {

        //Atributos asignados
        this.nombre = nombre;
        this.edad = edad;
        this.puntajeCrediticio = puntajeCrediticio;
        this.tieneDeudas = tieneDeudas;
        this.aniosEmpleo = aniosEmpleo;
        this.ingresoMensual = ingresoMensual;
        // TODO: Verificar invariante de clase
        verificarInvariante();
    }

    /*Evalúa una solicitud de préstamo.
    * PRECONDICIONES: 
       - sol != null 
       - monto > 0 
       - sol.getEdad() >= 0 
       - sol cumple su invariante

    * POSTCONDICIONES: 
       - Retorna APROBADO si: 
           puntaje >= 700 
           && !tieneDeudas 
           && monto <= 5 * ingreso
           && edad >= 18

       - Retorna REVISION_MANUAL si: 
           (puntaje >= 700 && tieneDeudas) 
           OR (puntaje entre 500 y 699 && empleo >= 2)

       - Retorna RECHAZADO en cualquier otro caso
   */
    private void verificarInvariante() {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        if (edad <= 0) {
            throw new IllegalArgumentException("Edad debe ser > 0");
        }
        if (puntajeCrediticio < 0 || puntajeCrediticio > 850) {
            throw new IllegalArgumentException(
                    "Puntaje debe estar entre 0 y 850");
        }
        if (aniosEmpleo < 0) {
            throw new IllegalArgumentException(
                    "Años de empleo no pueden ser negativos");
        }
        if (ingresoMensual < 0) {
            throw new IllegalArgumentException(
                    "Ingreso mensual no puede ser negativo");
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
