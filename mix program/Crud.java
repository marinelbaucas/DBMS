/*
 * This will serve as a code(crud) for songs
 */
package songscrud;
import java.util.Scanner;
import java.sql.*;

public class Crud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner user_input = new Scanner(System.in);
        // TODO code application logic here
            Class.forName("com.mysqljdbc.Driver");

            String conStr = "jdbc:mysql://localhost:3306/dbms?user=root&password=";
            Connection con = DriverManager.getConnection(conStr);
            System.out.println("Connected");

            String stSel = "SELECT * FROM songs";

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(stSel);

            System.out.println("Choose among the following choices:");
            System.out.println("1: Show Table\n2: Insert new data\n"
                + "3:Delete data\n4: Update table content");
            int choice = user_input.nextInt();

            /*SHOW TABLE*/
            if(choice == 1) {
                rs.beforeFirst();
                System.out.printf("%2s %10s %21s %26s", "song id", "title", "duration", "album number\n");

                while (rs.next()){
                    int songid = rs.getInt(1);
                    String title = rs.getString("title");
                    String duration = rs.getString("duration");
                    int albumno = rs.getInt("album_no");

                    System.out.printf("%-10d %-20s %25s %-15s\n", songid,
                        title, albumno);
                        user_input.close();
                }
              /*INSERT NEW DATA*/
            }else if(choice == 2){
                System.out.println("Song id: ");
                user_input.nextInt();
                int song_id = user_input.nextInt();
                System.out.println("Title: ");
                String title = user_input.nextLine();
                System.out.println("Duration: ");
                String duration = user_input.nextLine();
                System.out.println("Album no: ");
                user_input.nextInt();
                int album_no = user_input.nextInt();

                PreparedStatement psi;
                String stIns = "INSERT INTO songs(song_id, title, duration, album_no) VALUES(?,?,?,?)";
                psi = con.prepareStatement(stIns);
                psi.setInt(1, song_id);
                psi.setString(2, title);
                psi.setString(3, duration);
                psi.setInt(4, album_no);
                psi.executeUpdate();

            /*DELETE DATA*/
            }else if(choice == 3){
                rs.last();
                rs.deleteRow();

            /*UPDATE DATA*/
            }else if(choice == 4){
                System.out.println("Column Number: ");
                int columnNumber = user_input.nextInt();
                System.out.println("Row Number: ");
                int rowNumber = user_input.nextInt();
                System.out.println("Original Content: ");
                user_input.nextLine(); //Bypass Bug
                String originalContent = user_input.nextLine();
                System.out.println("New Content: ");
                String newContent = user_input.nextLine();
                rs.first();
                rs.updateString(columnNumber, originalContent); //Select the row
                rs.absolute(rowNumber); //Change the number to the corresponding row
                rs.updateString(columnNumber, newContent); //Change the selected row
                rs.updateRow();
            }
    }

}
