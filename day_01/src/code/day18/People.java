package code.day18;

import java.util.Objects;

public class People {

        private  String name;

        public People(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            System.out.println("使用equals");
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            People people = (People) o;
            return Objects.equals(name, people.name);
        }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
}
