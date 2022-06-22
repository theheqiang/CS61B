public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }


    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /**Return a double equal to the distance between the supplied planet and the planet that is doing the calculation */
    public double calcDistance(Planet p){
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;

        return Math.sqrt(dx * dx + dy * dy);
    }

    /**Return a double describing the force exerted on this planet by the given planet  */
    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);

        return (G * p.mass * this.mass) / (r * r);
    }

    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - this.xxPos;
        double f = calcForceExertedBy(p);
        double r = calcDistance(p);

        return f * dx / r;
    }
    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - this.yyPos;
        double f = calcForceExertedBy(p);
        double r = calcDistance(p);

        return f * dy / r;
    }


    public double calcNetForceExertedByX(Planet[] planets){
        double netForce = 0;

        for(Planet p : planets){
            if(this.equals(p)) continue;
            netForce += calcForceExertedByX(p);
        }

        return netForce;
    }

    public double calcNetForceExertedByY(Planet[] planets){
        double netForce = 0;

        for(Planet p : planets){
            if(this.equals(p)) continue;
            netForce += calcForceExertedByY(p);
        }

        return netForce;
    }


    public void update(double dt, double fX, double fY){
        double netAX = fX / this.mass;
        double netAY = fY / this.mass;
        this.xxVel += dt * netAX;
        this.yyVel += dt * netAY;

        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }


    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Planet planet = (Planet) o;

        if (Double.compare(planet.xxPos, xxPos) != 0) return false;
        if (Double.compare(planet.yyPos, yyPos) != 0) return false;
        if (Double.compare(planet.xxVel, xxVel) != 0) return false;
        if (Double.compare(planet.yyVel, yyVel) != 0) return false;
        if (Double.compare(planet.mass, mass) != 0) return false;
        return imgFileName.equals(planet.imgFileName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(xxPos);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(yyPos);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(xxVel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(yyVel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(mass);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + imgFileName.hashCode();
        return result;
    }
}