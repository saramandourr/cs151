public class Name {
    private String name;
    private YearData[] yearData;
    private int totalCount;
    public Name(String name) {
        this.name = name;
        this.yearData = new YearData[28];
        this.totalCount = 0;
    }
    public String getName() {
        return name;
    }
    public void updateYearData(int year, int rank, int count) {
        int index = year - 1990;
        if(index < 0 || index >= 28) return;
        if(yearData[index] == null) {
            yearData[index] = new YearData(year, rank, count);
        } else {
            yearData[index].setRank(rank);
            yearData[index].addCount(count);
        }
        totalCount += count;
    }
    public YearData getYearData(int year) {
        int index = year - 1990;
        if(index < 0 || index >= 28) return null;
        return yearData[index];
    }
    public int getTotalCount() {
        return totalCount;
    }
    public String toString() {
        return name;
    }
    public static class YearData {
        private int year;
        private int rank;
        private int count;
        public YearData(int year, int rank, int count) {
            this.year = year;
            this.rank = rank;
            this.count = count;
        }
        public int getYear() {
            return year;
        }
        public int getRank() {
            return rank;
        }
        public int getCount() {
            return count;
        }
        public void setRank(int rank) {
            this.rank = rank;
        }
        public void addCount(int additional) {
            this.count += additional;
        }
    }
}
