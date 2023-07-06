
package uasprakpbo;

import java.util.List;
import java.util.Scanner;

public class Uasprakpbo {
    private static TodoDAO todoDAO = new TodoDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("===== TODO LIST MENU =====");
            System.out.println("1. Tampilkan Todo List");
            System.out.println("2. Tambah Todo");
            System.out.println("3. Ubah Todo");
            System.out.println("4. Hapus Todo");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showTodoList();
                    break;
                case 2:
                    addTodo();
                    break;
                case 3:
                    updateTodo();
                    break;
                case 4:
                    deleteTodo();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Program selesai.");
    }

    private static void showTodoList() {
        List<Todo> todos = todoDAO.getAllTodos();

        if (todos.isEmpty()) {
            System.out.println("Todo List kosong.");
        } else {
            System.out.println("===== TODO LIST =====");
            for (Todo todo : todos) {
                System.out.println(todo);
            }
        }
    }

    private static void addTodo() {
        Todo todos = new Todo();

        System.out.print("Masukkan Todo : ");
        todos.setTodo(scanner.nextLine());

        System.out.print("Masukkan Kategori : ");
        todos.setKategori(scanner.nextLine());

        System.out.print("Masukkan Tanggal Selesai : ");
        todos.setTanggalSelesai(scanner.nextLine());

        System.out.print("Masukkan Status : ");
        todos.setStatus(scanner.nextLine());

        todoDAO.addTodo(todos);
        System.out.println("Todo berhasil ditambahkan.");
    }

    private static void updateTodo() {
        System.out.print("Masukkan ID Todo yang ingin diubah : ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Todo todo = new Todo();
        todo.setId(id);

        System.out.print("Masukkan Todo baru : ");
        todo.setTodo(scanner.nextLine());

        System.out.print("Masukkan Kategori baru : ");
        todo.setKategori(scanner.nextLine());

        System.out.print("Masukkan Tanggal Selesai baru : ");
        todo.setTanggalSelesai(scanner.nextLine());

        System.out.print("Masukkan Status baru : ");
        todo.setStatus(scanner.nextLine());

        todoDAO.updateTodo(todo);
        System.out.println("Todo berhasil diubah.");
    }

    private static void deleteTodo() {
        System.out.print("Masukkan ID Todo yang ingin dihapus : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        todoDAO.deleteTodo(id);
        System.out.println("Todo berhasil dihapus.");
    }
}
