package com.mycompany.actividadpost1u1;

public class Main {

    public static void main(String[] args) {

        // R1 → APROBADO
        Solicitante s1 = new Solicitante(
                "Ana", 30, 750, false, 5, 3000000);
        System.out.println("R1: " +
                EvaluadorPrestamo.evaluarPrestamo(s1, 10000000));

        // R2 → REVISION_MANUAL
        Solicitante s2 = new Solicitante(
                "Bob", 35, 720, true, 4, 4000000);
        System.out.println("R2: " +
                EvaluadorPrestamo.evaluarPrestamo(s2, 8000000));

        // R3 → REVISION_MANUAL (500–699 con empleo >= 2)
        Solicitante s3 = new Solicitante(
                "Carlos", 28, 600, false, 3, 2500000);
        System.out.println("R3: " +
                EvaluadorPrestamo.evaluarPrestamo(s3, 5000000));

        // R4 → RECHAZADO (500–699 con empleo < 2)
        Solicitante s4 = new Solicitante(
                "Diana", 26, 650, false, 1, 2500000);
        System.out.println("R4: " +
                EvaluadorPrestamo.evaluarPrestamo(s4, 4000000));

        // R5 → RECHAZADO (puntaje < 500)
        Solicitante s5 = new Solicitante(
                "Eduardo", 22, 400, false, 5, 3000000);
        System.out.println("R5: " +
                EvaluadorPrestamo.evaluarPrestamo(s5, 2000000));

        // R6 → RECHAZADO (edad < 18)
        Solicitante s6 = new Solicitante(
                "Felipe", 17, 750, false, 3, 3000000);
        System.out.println("R6: " +
                EvaluadorPrestamo.evaluarPrestamo(s6, 2000000));

        // R8 → RECHAZADO (monto > 5x ingreso)
        Solicitante s7 = new Solicitante(
                "Gabriela", 30, 780, false, 4, 2000000);
        System.out.println("R8: " +
                EvaluadorPrestamo.evaluarPrestamo(s7, 15000000));
    }
}