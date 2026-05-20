class TimeMap {

    private Map<String, List<Pair<Integer, String>>> store;

    public TimeMap() {
        this.store = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        store
            .computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = store.getOrDefault(key, new ArrayList<>());
        int l = 0, r = values.size() - 1;

        String result = "";
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (values.get(mid).getKey() <= timestamp) {
                l = mid + 1;
                result = values.get(mid).getValue();
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }
    }
}
