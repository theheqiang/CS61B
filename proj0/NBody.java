public class NBody {

    private static final String imageToDraw = "images/starfield.jpg";

    public static double readRadius(String filename){
        In in = new In(filename);

        in.readInt();
        double radius = in.readDouble();

        return radius;
    }

    public static int readPlanetCount(String filename){
        In in = new In(filename);

        return in.readInt();
    }


    public static Planet[] readPlanets(String filename){
        In in = new In(filename);

        int planetCount = in.readInt();
        in.readDouble();

        Planet[] planets = new Planet[planetCount];

        for (int i = 0; i < planetCount; i++) {
            planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }

        return planets;
    }


    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        int planetCount = readPlanetCount(filename);
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.enableDoubleBuffering();

        double count = 0;


        StdDraw.setScale(-radius, radius);

        while(count < T){
            double[] xForces = new double[planetCount];
            double[] yForces = new double[planetCount];
            for(int i = 0; i < planetCount; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i = 0; i < planetCount; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            // draw the backgroud picture
            StdDraw.picture(0, 0, "images/starfield.jpg");

            // draw all the planets
            for (Planet planet : planets) {
                planet.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            count += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planetCount; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }
}