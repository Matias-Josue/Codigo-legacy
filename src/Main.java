void main() {
    IO.println("""
        ===============================================
        |      SISTEMA DE ACCESO - CYBERLAB           |
        |       Laboratorio de Programacion          |
        ===============================================
        """);

    String nombreUsuario = "";
    String cursoRequerido = "Fundamentos de Programacion ";
    double calificacionCurso = 0.0;

    IO.println("Ingrese el nombre del usuario: ");
    nombreUsuario = IO.readln();

    IO.println("¿Es usuario registrado anteriormente? (S/N): ");
    String usuarioRegistrado = IO.readln();

    String[] historialCursos = new String[0];

    if (usuarioRegistrado.equalsIgnoreCase("S")) {
        historialCursos = new String[]{ cursoRequerido };

        String ingresoNota = IO.readln(
                "Ingrese la calificacion obtenida en '" + cursoRequerido + "' (0-10): "
        );

        calificacionCurso = Double.parseDouble(ingresoNota);

    } else {
        IO.println("-> Registrando como usuario nuevo...");

        historialCursos = new String[]{ cursoRequerido };

        String ingresoNota = IO.readln(
                "Ingrese la calificacion obtenida en '" + cursoRequerido + "' (0-10): "
        );

        calificacionCurso = Double.parseDouble(ingresoNota);
    }

    IO.println("\n--- SOLICITUD DE ACCESO ---");
    IO.println(
            "Area solicitada: [ Laboratorio Avanzado ] " +
                    "(Requisito: aprobar Fundamentos con >= 7.0)"
    );

    String solicitarAcceso = IO.readln(
            "¿Desea solicitar acceso al laboratorio? (S/N): "
    );

    if (solicitarAcceso.equalsIgnoreCase("S")) {

        boolean tieneRequisito = false;

        for (int i = 0; i < historialCursos.length; i++) {
            if (historialCursos[i].equalsIgnoreCase(cursoRequerido)) {
                tieneRequisito = true;
            }
        }

        String resultadoAcceso = switch (String.valueOf(tieneRequisito)) {

            case "true" -> {
                if (calificacionCurso == 10.0) {
                    yield """
                        ACCESO APROBADO
                        Cumple con el requisito academico.
                        ¡Felicidades! Ha sido seleccionado como
                        asistente del Laboratorio de Programacion .
                        """;

                } else if (calificacionCurso >= 7.0) {
                    yield "ACCESO APROBADO: Cumple con el requisito academico.";

                } else {
                    yield "ACCESO RECHAZADO: No aprobo el curso con "
                            + calificacionCurso;
                }
            }

            case "false" ->
                    "ACCESO RECHAZADO: No cuenta con el curso requerido.";

            default ->
                    "Error del sistema.";
        };

        IO.println("\n[RESULTADO]: " + resultadoAcceso);

    } else {
        IO.println(
                "\nProceso finalizado. No se solicito acceso al laboratorio."
        );
    }
}