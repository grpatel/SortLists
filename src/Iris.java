public class Iris implements Comparable<Iris> {
        private double sepal_Length;
        private double sepal_width;
        private double petal_Length;
        private double petal_width;
        private String species;

        //default constructor
        public Iris() {
            this.sepal_Length = 0;
            this.sepal_width = 0;
            this.petal_Length = 0;
            this.petal_width = 0;
            this.species = " ";
        }

        //parameterized constructor
        public Iris(double sepal_Length, double sepal_width, double petal_Length, double petal_width, String species) {
            this.sepal_Length = sepal_Length;
            this.sepal_width = sepal_width;
            this.petal_Length = petal_Length;
            this.petal_width = petal_width;
            this.species = species;
        }

        //copy constructor
        Iris(Iris c) {
            sepal_Length = c.sepal_Length;
            sepal_width = c.sepal_width;
            petal_Length = c.petal_Length;
            petal_width = c.petal_width;
            species = c.species;
        }
        public void setSepal_Length(double s){
            this.sepal_Length = s;
        }

        public void setPetal_Length(double p){
            this.petal_Length = p;
        }
        public void setPetal_width(double p){
            this.petal_width = p;
        }
        public void setSepal_width(double p){
            this.sepal_width = p;
        }
        public void setSpecies (String p){
            this.species = p;
        }

        public double getSepal_Length(){
            return sepal_Length;
        }
        public double getSepal_width(){
            return sepal_width;
        }
        public double getPetal_Length(){
            return petal_Length;
        }
        public double getPetal_width(){
            return petal_width;
        }
        public String getSpecies(){
            return species;
        }
        public String toString() {
            return "(" + sepal_Length + ", " + sepal_width + ", " + petal_Length + ", " + petal_width + "" + species  + ")";
        }

        @Override
        public int compareTo(Iris Iris2) {
            if (this.sepal_Length < Iris2.sepal_Length){
                return -1;
            } else if (this.sepal_Length == Iris2.sepal_Length) {
                if (this.petal_Length < Iris2.petal_Length) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }

        boolean isLessThan(Iris Iris2) {
            return compareTo(Iris2) < 0;
        }

    }

    
