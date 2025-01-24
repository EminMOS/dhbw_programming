public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        System.out.println(Math.floorMod(-5, 360));

        HeatMap map = new HeatMap(10);
        map.setValueAt(10.0f, 10.0f, 1.0f);
        map.setValueAt(180.0f, 10.0f, 1.0f);
        map.setValueAt(270.0f, 80.0f, 1.0f);
        map.setValueAt(400.0f, 270.0f, 1.0f);
        map.asBlurred().exportPng();
}
}