import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Song — ADT แทน "เพลง" หนึ่งเพลง
 *
 * ⚠️ โค้ดตั้งต้นนี้ "ใช้งานได้" แต่มีบั๊กแบบเดียวกับกรณีศึกษาในสไลด์:
 *    rep exposure ทั้งขาเข้าและขาออก, producer ที่แอบ mutate ตัวเอง,
 *    ไม่ validate input และยังไม่ override equals/hashCode
 *
 * ภารกิจของคุณ: ทำให้ Song เป็น immutable class ที่ถูกต้อง "ครบสูตร 6 ข้อ"
 * และ override equals()/hashCode() ตามสัญญาของ Java (ดูรายละเอียดใน README.md)
 */
public final class Song {

    private final String title;
    private final String artist;
    private final List<String> tags;

  public Song(String title, String artist, List<String> tags) {
    // title และ artist ห้าม null หรือว่าง
    if (title == null || title.isBlank()) {
        throw new IllegalArgumentException("title must not be null or blank");
    }

    if (artist == null || artist.isBlank()) {
        throw new IllegalArgumentException("artist must not be null or blank");
    }

    // tags ห้าม null
    if (tags == null) {
        throw new IllegalArgumentException("tags must not be null");
    }

    // tags ห้ามมีสมาชิกเป็น null หรือว่าง
    for (String tag : tags) {
        if (tag == null || tag.isBlank()) {
            throw new IllegalArgumentException("tags must not contain null or blank values");
        }
    }

    this.title = title;
    this.artist = artist;
    this.tags = List.copyOf(tags);
}

    // ---------- observers ----------

    public String title() {
        return title;
    }

    public String artist() {
        return artist;
    }

    public List<String> tags() {
        // TODO(1.3): ✗ ส่งลูกศรออกไปตรง ๆ = rep exposure ขาออก → คืน "สำเนา"
        return new ArrayList<>(tags);
    }

    // ---------- producer ----------

    /**
     * spec: คืน Song "ตัวใหม่" ที่มีแท็กเพิ่มต่อท้าย — ห้ามแก้ตัวเดิม
     * @throws IllegalArgumentException เมื่อ tag เป็น null/ว่าง
     */
    public Song withTag(String tag) {
        if (tag == null || tag.isBlank()) {
            throw new IllegalArgumentException("tag must not be null or blank");
        }
        List<String> copy = new ArrayList<>(tags);
        copy.add(tag);
        return new Song(title, artist, copy);
    }

    // ---------- equality ----------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song other = (Song) o;
        return title.equals(other.title)
            && artist.equals(other.artist)
            && tags.equals(other.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, tags);
    }

    @Override
    public String toString() {
        return title + " — " + artist + " " + tags;
    }
    
}

