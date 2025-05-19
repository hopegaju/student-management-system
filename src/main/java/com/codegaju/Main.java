package com.codegaju;

public class Main {
    public static void main(String[] args) {
//        Student S = new Student("Michou", "Raissa", "mischou@gmail.com","2025-06-03");
//        Student S1 = new Student("Daryce", "Mwambutsa", "michou@gmail.com","2025-06-03");
//        Student S2 = new Student("Evodie", "NDAYIISHIMIYE", "Evodie@gmail.com","2025-06-03");
//        Student S3 = new Student("Sonia", "Uwamahoro", "Uwamahoro@gmail.com","2025-06-03");
//        Student S4 = new Student("Queen", "Gaju", "gaju@gmail.com","2025-06-03");
        StudentDAO dao = new StudentDAO();
//        dao.create(S);
//        dao.create(S1);
//        dao.create(S2);
//        dao.create(S3);
//        dao.create(S4)
        dao.read(4);
        dao.readAll().forEach(st -> System.out.println(st.getEmail()));
        dao.readAll().forEach(st -> System.out.println(st.getFirstName()));
        dao.readAll().forEach(st -> System.out.println(st.getLastName()));
        dao.readAll().forEach(st -> System.out.println(st.getBirthDate()));
        dao.update("Evodie");
    }
}