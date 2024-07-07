package logic;

public record Position (int x, int y) {
    public static Position getPosFromString(String pos){
        int x = -1;
        int y = -1;

        // Finde die Position des Kommas
        int commaIndex = pos.indexOf(',');

        if (commaIndex != -1) {
            // Extrahiere die Zeichen bis zum Komma
            String beforeComma = pos.substring(0, commaIndex);
            x = Integer.parseInt(beforeComma);

            // Extrahiere die Zeichen ab dem Komma bis zum Ende
            String afterComma = pos.substring(commaIndex + 1);
            y = Integer.parseInt(afterComma);
        } else {
            System.out.println("Keine gültige Position.");
        }
        return new Position(x, y);
    }
}
