package com.mycompany.actividadpost1u1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class TestEvaluadorPrestamos {

        /**
         * R1:
         * Puntaje >= 700
         * Sin deudas
         * Monto válido
         * → Debe aprobar automáticamente
         */
        @Test
        @DisplayName("R1: Puntaje>=700, sin deudas, monto válido -> APROBADO")
        void testRegla1AprobadoAutomatico() {
                Solicitante sol = new Solicitante("Ana", 30,
                                750, false, 5.0, 3000.0);

                ResultadoPrestamo result = EvaluadorPrestamo.evaluarPrestamo(sol, 10000.0);

                assertEquals(ResultadoPrestamo.APROBADO, result);
        }

        /**
         * R2:
         * Puntaje >= 700
         * Con deudas
         * → Revisión manual
         */
        @Test
        @DisplayName("R2: Puntaje>=700, con deudas -> REVISION_MANUAL")
        void testRegla2PuntajeAltoConDeudas() {
                Solicitante sol = new Solicitante("Bob", 35,
                                720, true, 3.0, 4000.0);

                ResultadoPrestamo result = EvaluadorPrestamo.evaluarPrestamo(sol, 8000.0);

                assertEquals(ResultadoPrestamo.REVISION_MANUAL, result);
        }

        /**
         * R3:
         * Puntaje entre 500 y 699
         * Empleo >= 2 años
         * → Revisión manual
         */
        @Test
        @DisplayName("R3: Puntaje 500-699 y empleo >=2 -> REVISION_MANUAL")
        void testRegla3RevisionPorEmpleoEstable() {
                Solicitante sol = new Solicitante("Carlos", 28,
                                600, false, 3.0, 2500.0);

                ResultadoPrestamo result = EvaluadorPrestamo.evaluarPrestamo(sol, 5000.0);

                assertEquals(ResultadoPrestamo.REVISION_MANUAL, result);
        }

        /**
         * R4:
         * Puntaje entre 500 y 699
         * Empleo < 2 años
         * → Rechazado
         */
        @Test
        @DisplayName("R4: Puntaje 500-699 y empleo <2 -> RECHAZADO")
        void testRegla4RechazadoPorEmpleoInestable() {
                Solicitante sol = new Solicitante("Diana", 26,
                                650, false, 1.0, 2500.0);

                ResultadoPrestamo result = EvaluadorPrestamo.evaluarPrestamo(sol, 4000.0);

                assertEquals(ResultadoPrestamo.RECHAZADO, result);
        }

        /**
         * R5:
         * Puntaje < 500
         * → Rechazado
         */
        @Test
        @DisplayName("R5: Puntaje <500 -> RECHAZADO")
        void testRegla5RechazadoPorBajoPuntaje() {
                Solicitante sol = new Solicitante("Eduardo", 22,
                                400, false, 5.0, 3000.0);

                ResultadoPrestamo result = EvaluadorPrestamo.evaluarPrestamo(sol, 2000.0);

                assertEquals(ResultadoPrestamo.RECHAZADO, result);
        }

        /**
         * R6:
         * Edad < 18
         * → Rechazado
         */
        @Test
        @DisplayName("R6: Edad <18 -> RECHAZADO")
        void testRegla6MenorEdad() {
                Solicitante sol = new Solicitante("Felipe", 17,
                                750, false, 3.0, 3000.0);

                ResultadoPrestamo result = EvaluadorPrestamo.evaluarPrestamo(sol, 2000.0);

                assertEquals(ResultadoPrestamo.RECHAZADO, result);
        }

        /**
         * R8:
         * Monto > 5x ingreso
         * → Rechazado
         */
        @Test
        @DisplayName("R8: Monto mayor a 5x ingreso -> RECHAZADO")
        void testRegla8MontoExcedido() {
                Solicitante sol = new Solicitante("Gabriela", 30,
                                780, false, 4.0, 2000.0);

                ResultadoPrestamo result = EvaluadorPrestamo.evaluarPrestamo(sol, 15000.0);

                assertEquals(ResultadoPrestamo.RECHAZADO, result);
        }

        /**
         * Caso límite:
         * Puntaje >= 700
         * Sin deudas
         * Monto exactamente igual a 5x ingreso
         * → Debe aprobar (porque es <= 5x ingreso)
         */
        @Test
        @DisplayName("Caso límite: Monto exactamente 5x ingreso -> APROBADO")
        void testCasoLimiteMontoExacto() {
                Solicitante sol = new Solicitante("Hector", 40,
                                800, false, 10.0, 2000.0);

                // 5 * 2000 = 10000
                ResultadoPrestamo result = EvaluadorPrestamo.evaluarPrestamo(sol, 10000.0);

                assertEquals(ResultadoPrestamo.APROBADO, result);
        }

        // ===============================
        // TESTS DE PRECONDICIONES
        // ===============================

        /**
         * Precondición:
         * Monto debe ser positivo.
         */
        @Test
        @DisplayName("Precondición: Monto negativo -> excepción")
        void testPrecondicionMontoNegativo() {
                Solicitante sol = new Solicitante("Laura", 25,
                                600, false, 1.0, 2000.0);

                assertThrows(IllegalArgumentException.class,
                                () -> EvaluadorPrestamo.evaluarPrestamo(sol, -500.0));
        }

        /**
         * Precondición:
         * Solicitante no puede ser null.
         */
        @Test
        @DisplayName("Precondición: Solicitante null -> excepción")
        void testPrecondicionSolicitanteNull() {
                assertThrows(IllegalArgumentException.class,
                                () -> EvaluadorPrestamo.evaluarPrestamo(null, 5000.0));
        }
}