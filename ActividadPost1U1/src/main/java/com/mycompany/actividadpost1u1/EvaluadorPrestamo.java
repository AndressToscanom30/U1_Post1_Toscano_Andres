package com.mycompany.actividadpost1u1;

/*@author tosca*/

public class EvaluadorPrestamo {

    public static ResultadoPrestamo evaluarPrestamo(Solicitante sol, double monto) {
        // === PRECONDICIONES ===
        if (sol == null) { 
            throw new IllegalArgumentException("Solicitante no puede ser null");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("Monto debe ser positivo");
        }
        
        ResultadoPrestamo resultado;
        
        //Reglas según la tabla de decisión************
        
        //R6: Edad < 18 --> RECHAZADO
        if (sol.getEdad() < 18){
            resultado = ResultadoPrestamo.RECHAZADO;
        }
        //R8: Monto > ingreso * 5 --> RECHAZADO
        else if (monto > sol.getIngresoMensual()* 5){
            resultado = ResultadoPrestamo.RECHAZADO;
        }
        
        //R1: Puntaje >= 700, sin deudas, monto válido
        else if (sol.getPuntajeCrediticio() >= 700 && !sol.isTieneDeudas()){
            resultado = ResultadoPrestamo.APROBADO;
        }
        
        //R2: Puntaje >= 700, con deudas --> REVISION_MANUAL
        else if (sol.getPuntajeCrediticio() >= 700 && sol.isTieneDeudas()){
            resultado = ResultadoPrestamo.REVISION_MANUAL;
        }
        
        //R3: Puntaje entre 699 y 500, empleo por 2 o más años --> REVISION_MANUAL
        else if (sol.getPuntajeCrediticio() >= 500 && sol.getPuntajeCrediticio() <= 699 && sol.getAniosEmpleo() >= 2){
            resultado = ResultadoPrestamo.REVISION_MANUAL;
        }
        
        //R4: Puntaje > 500 pero < 700, añosTrabajo < 2
        else if (sol.getPuntajeCrediticio() >= 500 && sol.getPuntajeCrediticio() <= 699 && sol.getAniosEmpleo() < 2){
            resultado = ResultadoPrestamo.RECHAZADO;
        }
        
        //R5 / R7 --> Puntaje < 500
        else if (sol.getPuntajeCrediticio() < 500){
            resultado = ResultadoPrestamo.RECHAZADO;
        }
        
        //Y cualquier otra condición debería ser rechazado (seguridad extra)
        else {
            resultado = ResultadoPrestamo.RECHAZADO;
        }
        
        return resultado;
    }
}