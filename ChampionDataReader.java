import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Champion {
    private int id;
    private String apiname;
    private String title;
    private int difficulty;
    private String herotype;
    private String alttype;
    private String resource;
    private String stats; // JSON format
    private String rangetype;
    private String date;
    private String patch;
    private String changes; // JSON format
    private String role;
    private String client_positions;
    private String external_positions;
    private int damage;
    private int toughness;
    private int control;
    private int mobility;
    private int utility;
    private String style;
    private String adaptivetype;
    private int be;
    private int rp;
    private String skill_i;
    private String skill_q;
    private String skill_w;
    private String skill_e;
    private String skill_r;
    private String skills; // JSON format
    private String fullname;
    private String nickname;

    // Constructor
    public Champion(int id, String apiname, String title, int difficulty, String herotype, String alttype, String resource,
                    String stats, String rangetype, String date, String patch, String changes, String role,
                    String client_positions, String external_positions, int damage, int toughness, int control,
                    int mobility, int utility, String style, String adaptivetype, int be, int rp, String skill_i,
                    String skill_q, String skill_w, String skill_e, String skill_r, String skills, String fullname,
                    String nickname) {
        this.id = id;
        this.apiname = apiname;
        this.title = title;
        this.difficulty = difficulty;
        this.herotype = herotype;
        this.alttype = alttype;
        this.resource = resource;
        this.stats = stats;
        this.rangetype = rangetype;
        this.date = date;
        this.patch = patch;
        this.changes = changes;
        this.role = role;
        this.client_positions = client_positions;
        this.external_positions = external_positions;
        this.damage = damage;
        this.toughness = toughness;
        this.control = control;
        this.mobility = mobility;
        this.utility = utility;
        this.style = style;
        this.adaptivetype = adaptivetype;
        this.be = be;
        this.rp = rp;
        this.skill_i = skill_i;
        this.skill_q = skill_q;
        this.skill_w = skill_w;
        this.skill_e = skill_e;
        this.skill_r = skill_r;
        this.skills = skills;
        this.fullname = fullname;
        this.nickname = nickname;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getApiname() {
        return apiname;
    }

    public String getTitle() {
        return title;
    }

    // Add other getters as needed...

    @Override
    public String toString() {
        return "Champion{" +
                "id=" + id +
                ", apiname='" + apiname + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

public class ChampionDataReader {
    public static void main(String[] args) {
        String csvFile = "champion_data.csv"; // Ganti dengan path file CSV Anda
        String line;
        String csvSplitBy = ";";
        List<Champion> champions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                // Cek apakah data lengkap
                if (data.length < 33 || data[0].isEmpty()) {
                    System.out.println("Baris tidak lengkap atau kosong: " + line);
                    continue; // Lewati baris ini
                }

                // Membaca data dan menyimpan ke dalam objek Champion
                Champion champion = new Champion(
                        Integer.parseInt(data[1]), // id
                        data[2],                    // apiname
                        data[3],                    // title
                        Integer.parseInt(data[4]), // difficulty
                        data[5],                    // herotype
                        data[6],                    // alttype
                        data[7],                    // resource
                        data[8],                    // stats
                        data[9],                    // rangetype
                        data[10],                   // date
                        data[11],                   // patch
                        data[12],                   // changes
                        data[13],                   // role
                        data[14],                   // client_positions
                        data[15],                   // external_positions
                        Integer.parseInt(data[16]), // damage
                        Integer.parseInt(data[17]), // toughness
                        Integer.parseInt(data[18]), // control
                        Integer.parseInt(data[19]), // mobility
                        Integer.parseInt(data[20]), // utility
                        data[21],                   // style
                        data[22],                   // adaptivetype
                        Integer.parseInt(data[23]), // be
                        Integer.parseInt(data[24]), // rp
                        data[25],                   // skill_i
                        data[26],                   // skill_q
                        data[27],                   // skill_w
                        data[28],                   // skill_e
                        data[29],                   // skill_r
                        data[30],                   // skills
                        data[31],                   // fullname
                        data[32]                    // nickname
                );

                champions.add(champion);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }

        // Output salah satu data champion
        if (!champions.isEmpty()) {
            System.out.println("Contoh Champion: " + champions.get(0));
        }
    }
}