
public final class CountingNotifier implements Notifier {

    

    /**
     * @param inner ช่องทางจริงที่จะมอบงานให้ ห้าม null
     * @throws IllegalArgumentException เมื่อ inner เป็น null
     */
    public CountingNotifier(Notifier inner) {
        // TODO(3.2): validate แล้วเก็บ inner
    }

    @Override
    public void send(String message) {
        // TODO(3.3): นับหนึ่งครั้ง แล้ว delegate ให้ inner.send(...)
    }

    /** จำนวนครั้งที่ send ถูกเรียกบน wrapper ตัวนี้ */
    public int sendCount() {
        // TODO(3.4): คืนค่าตัวนับจริง
        return -1;
    }
}
