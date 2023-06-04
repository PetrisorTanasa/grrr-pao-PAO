package main.java.exercitii;

import java.io.*;
import java.nio.channels.SelectionKey;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Sir{
    private String sir;

    public Sir(String sir){
        this.sir = sir;
    }
    public void modificaSir(String sir){
        this.sir = sir;
    }
    public void modificaSir(Sir sir){
        sir = new Sir("Mihai");
    }
    public String getSir(){
        return sir;
    }
}
class Test {
    public static void main(String[] args){
        Sir s = new Sir("Ion");
        Sir t = new Sir("Alex");
        s.modificaSir("Matei");
        t.modificaSir(new Sir("Dan"));
        s.modificaSir(t);
        System.out.println(s.getSir() + " " + t.getSir());
//        String s = "abra/ca/dabra";
//        System.out.println(s.split("/")[1]);
//        s = s.toUpperCase();
//        System.out.println(s);
//        int p = s.indexOf("B");
//        int q = s.lastIndexOf("B");
//        System.out.println(p);
//        System.out.println(q);
//        s = s.substring(0, s.length() + p - q);
//        System.out.println(s.length());
//        System.out.println(s);
//        String s = "";
//        for (int i=0 ; i<=5 ; i++){
//            s += i;
//            s += 5-i;
//        }
//
//        int p = s.lastIndexOf("2");
//        s = s.substring(p);
//        System.out.println(s.length());
//        System.out.println(s);
//        for(int i=1; i<=5 ; i++){
//            try(Scanner sc = new Scanner(new File("file")))
//        }
//        ObjectOutputStream oos = new ObjectOutputStream(
//                new FileOutputStream("persoana.ser")
//        );
//        Persoana p = new Persoana("Popescu Ion",40), q = p;
//        oos.writeObject(q);
//        oos.close();
//
//        ObjectInputStream ois = new ObjectInputStream(
//                new FileInputStream("persoana.ser")
//        );
//        Persoana r = (Persoana) ois.readObject();
//       ois.close();

//        ArrayList<Student> stud = new ArrayList<>();
//        stud.add(new Student(2,"Tanasa",2011,"Biologia","bio",10));
//        stud.add(new Student(3,"Florin",2018,"FMI","info",9));
//        stud.add(new Student(2,"Petrisor",2009,"FMI","mate",9));
//        stud.add(new Student(1,"TFP",2011,"Biologia","bio",10));
//
//        stud.stream().filter(p->p.getAn()>2000 && p.getAn()<2010).sorted(Comparator.comparing(Student::getMedie).reversed()).forEach(System.out::println);
//
//        stud.stream().filter(p -> p.getFacultate().equals("FMI")).map(Student::getSpecializare).distinct().forEach(System.out::println);
//
//        List<String> eleviPremianti = stud.stream().filter(p -> p.getMedie() == 10).map(Student::getAbsolvent).distinct().collect(Collectors.toList());
//
//        Map<String,Optional<Student>> elevi = stud.stream().collect(Collectors.groupingBy(p -> p.getSpecializare(),
//                Collectors.minBy(Comparator.comparing(Student::getMedie))));
//        for (Map.Entry<String,Optional<Student>> entry : elevi.entrySet()) {
//            String destinatie = entry.getKey();
//            System.out.println(entry.getValue());
//        }


//
//for (String elev:eleviPremianti){
//    System.out.println(elev);
//}
//        long a = stud.stream().filter(p -> p.getSpecializare().equals("info")).collect(Collectors.counting());
//        System.out.println(a);
        //        CitireThread citThr1 = new CitireThread("C:\\Users\\Petrisor Tanasa\\Desktop\\grrr-pao-PAO\\lucru lab\\src\\main\\java\\exercitii\\sucursalaSafeLife_1.txt");
//        CitireThread citThr2 = new CitireThread("C:\\Users\\Petrisor Tanasa\\Desktop\\grrr-pao-PAO\\lucru lab\\src\\main\\java\\exercitii\\sucursalaSafeLife_2.txt");
//        Thread cit1 = new Thread(citThr1);
//        Thread cit2 = new Thread(citThr2);
//
//        cit1.start();
//        cit2.start();
//
//        cit1.join();
//        cit2.join();
//
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("Introduceti lungimea cuvintelor: ");
//        int n = in.nextInt();
//        CitireThread.cuvinte.stream().filter(p -> p.length() == n).distinct().forEach(System.out::println);
//        HashSet <Automobil> la = new HashSet<>();
//        la.add(new Automobil("Audi"));
//
//        la.add(new Automobil("BMW"));
//
//        la.add(new Automobil("Audi"));
//
//        la.add(new Automobil("Opel"));
//
//        System.out.println(la.size());
//        List<String> cuvinte = List.of(new String[]{"a", "b", "a"});
//
//        Map<String, Long> cuv = cuvinte.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
//
//                for (Map.Entry<String, Long> entry : cuv.entrySet()) {
//            String destinatie = entry.getKey();
//            Long stringE = entry.getValue();
//                    System.out.println("Cuvant: " + destinatie);
//            System.out.println("Aparitii: " + stringE);
//            System.out.println("--------------");
//        }
//        ArrayList<Vacanta> vacante =  new ArrayList<>();
//        vacante.add(new Vacanta("Dubai",2,3000,"01/09/2022-02/09/2022"));
//        vacante.add(new Vacanta("Ferentari",10,30000,"01/09/2022-02/09/2022"));
//        vacante.add(new Vacanta("Rahova",5,2550,"01/09/2022-02/09/2022"));
//        vacante.add(new Vacanta("Dubai",2,3000,"01/08/2022-02/08/2022"));
//
//        vacante.add(new Vacanta("Bucuresti",2,3000,"01/08/2022-02/08/2022"));
//        vacante.add(new Vacanta("Bucuresti",2,10900,"01/08/2022-02/08/2022"));
//
//        vacante.stream().filter(p -> p.getNrPersoane() == 2).sorted(Comparator.comparing(Vacanta::getValoare).reversed()).forEach(System.out::println);
//
//        vacante.stream().flatMap(p -> Stream.of(p.getDestinatie())).distinct().forEach(System.out::println);
//
//        List<Vacanta> vacanteDubai = vacante.stream().filter(p -> p.getDestinatie() == "Dubai"
//        && p.getPerioada().split("/")[1].equals("09") && p.getPerioada().split("/")[3].equals("09"))
//                .collect(Collectors.toList());
//        for( Vacanta vac : vacanteDubai){
//            System.out.println(vac);
//        }
//
//        Map<String, List<Vacanta>> vacGrupate = vacante.stream().collect(Collectors.groupingBy(p -> p.getDestinatie()));
//
//        for (Map.Entry<String, List<Vacanta>> entry : vacGrupate.entrySet()) {
//            String destinatie = entry.getKey();
//            List<Vacanta> vacanteE = entry.getValue();
//
//            System.out.println("Destinatie: " + destinatie);
//            for (Vacanta vacanta : vacanteE) {
//                System.out.println(vacanta);
//            }
//            System.out.println("--------------");
//        }
//        List<Vacanta> vacanteBucuresti = vacante.stream().filter(p -> p.getDestinatie() == "Bucuresti" && 50000 > p.getValoare() && p.getValoare() > 10000)
//                .collect(Collectors.toList());
//
//        for(Vacanta v : vacanteBucuresti){
//            System.out.println(v);
//        }
//
//        Map<String, List<Vacanta>> locatiiVacante = vacanteBucuresti.stream().collect(Collectors.groupingBy(p -> p.getDestinatie()));

        //EX1
//        C ob1 = new C();
//        ob1.met();
//        C ob2 = new C();
//        ob2.met();
//        System.out.println(ob1.a + ob2.b);
        //EX2
//        String s = "academicion";
//        int p = s.lastIndexOf("c");
//        int q = s.indexOf(s.charAt(p));
//        s = s.substring(q,p);
//        System.out.println(s);
    }
    //RESTANTA 2017
    // EX 3
//    public static void main(String[] args) throws InterruptedException {
//        CitireThread citThr1 = new CitireThread("C:\\Users\\Petrisor Tanasa\\Desktop\\grrr-pao-PAO\\lucru lab\\src\\main\\java\\exercitii\\sucursalaSafeLife_1.txt");
//        CitireThread citThr2 = new CitireThread("C:\\Users\\Petrisor Tanasa\\Desktop\\grrr-pao-PAO\\lucru lab\\src\\main\\java\\exercitii\\sucursalaSafeLife_2.txt");
//        Thread cit1 = new Thread(citThr1);
//        Thread cit2 = new Thread(citThr2);
//
//        cit1.start();
//        cit2.start();
//
//        cit1.join();
//        cit2.join();
//
//        Double suma_totala = CitireThread.asigurari.stream().collect(Collectors.summingDouble(p -> p.getValoare()));
//        System.out.println(suma_totala);
//
//    }
    // EX 2
//    public static void main(String[] args) {
//        ArrayList<Asigurarea> asigurari = new ArrayList<>();
//        asigurari.add(new Asigurarea("RCA","Tanasa",2000,"Bucuresti"));
//        asigurari.add(new Asigurarea("Masina","Florin",20000,"Bucuresti"));
//        asigurari.add(new Asigurarea("RCA","Petrisor",30000,"Ploiesti"));
//        asigurari.add(new Asigurarea("RCA","Petrisor",30000,"Ploiesti"));
//
//        asigurari.stream().filter(p -> p.getTip().equals("RCA"))
//                .sorted(Comparator.comparing(Asigurarea::getValoare))
//                .forEach(System.out::println);
//        asigurari.stream().flatMap(p -> Stream.of(p.getLocalitate())).distinct().forEach(System.out::println);
//
//        List<Asigurarea> asigurarea2 = asigurari.stream().filter(p -> p.getLocalitate().equals("Bucuresti") && p.getValoare() >10000 && p.getValoare() < 50000)
//                .collect(Collectors.toList());
//
//        Map<String, List<Asigurarea>> asigurarea3 = asigurari.stream().collect(Collectors.groupingBy(p -> p.getTitular()));
//    }
}