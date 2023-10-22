public class Triangle {
    private Point[] vertices;

    public Triangle(Point[] vertices) {
        this.vertices = vertices;
    }

    public double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < vertices.length - 1; i++) {
            perimeter += calculateDistance(vertices[i], vertices[i + 1]);
        }
        perimeter += calculateDistance(vertices[vertices.length - 1], vertices[0]);
        return perimeter;
    }

    public boolean isEquilateral() {
        double side1 = calculateDistance(vertices[0], vertices[1]);
        double side2 = calculateDistance(vertices[1], vertices[2]);
        double side3 = calculateDistance(vertices[2], vertices[0]);

        return (side1 == side2 && side2 == side3);
    }

    public boolean isIsosceles() {
        double side1 = calculateDistance(vertices[0], vertices[1]);
        double side2 = calculateDistance(vertices[1], vertices[2]);
        double side3 = calculateDistance(vertices[2], vertices[0]);

        return (side1 == side2 || side1 == side3 || side2 == side3);
    }

    public double area() {
        double side1 = calculateDistance(vertices[0], vertices[1]);
        double side2 = calculateDistance(vertices[1], vertices[2]);
        double side3 = calculateDistance(vertices[2], vertices[0]);
        double s = (side1 + side2 + side3) / 2;

        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public boolean isInside(Point p) {
        double areaABC = area();
        double areaPBC = new Triangle(new Point[]{p, vertices[1], vertices[2]}).area();
        double areaAPC = new Triangle(new Point[]{vertices[0], p, vertices[2]}).area();
        double areaABP = new Triangle(new Point[]{vertices[0], vertices[1], p}).area();

        return areaABC == areaPBC + areaAPC + areaABP;
    }
}
