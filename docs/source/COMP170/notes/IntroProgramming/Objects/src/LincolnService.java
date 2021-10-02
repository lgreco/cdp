public class LincolnService {
    public static void main(String[] args) {

        TrainStation chi = new TrainStation("CHI", "Chicago Union Station");
        TrainStation sum = new TrainStation("SUM", "Summit");
        TrainStation jol = new TrainStation("JOL", "Joliet");
        TrainStation dwi = new TrainStation("DWI", "Dwight");

        sum.setNextStation(jol);

    }
}
