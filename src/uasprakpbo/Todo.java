
package uasprakpbo;

public class Todo {
    private int id;
    private String todo;
    private String kategori;
    private String tanggalSelesai;
    private String status;

    Todo(int id, String todo, String kategori, String tanggalSelesai, String Status) {
      this.id = id;
      this.todo = todo;
      this.kategori = kategori;
      this.tanggalSelesai = tanggalSelesai;
      this.status = status;
   }

    Todo() {
      
    }
   
    public String getTodo() {
        return todo;
    }

    public String getKategori() {
        return kategori;
    }

    public String getTanggalSelesai() {
        return tanggalSelesai;
    }

    public String getStatus() {
       return status;
    }

    int setId(int aInt) {
        return id;
    }

    String setTodo(String string) {
        return todo;
    }

    String setKategori(String string) {
        return kategori;
    }

    String setTanggalSelesai(String string) {
        return tanggalSelesai;
    }

    String setStatus(String string) {
        return status;
    }

    int getId() {
       return id;
    }
    
}