package importnew;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by geven_zhang on 16/8/5.
 */
public class TestCollection {

    public static void main(String[] args) {
        TestCollection testCollection = new TestCollection();
        List<SharedBoardSmsWrapper> source = new ArrayList<SharedBoardSmsWrapper>();

        SharedBoardSmsWrapper sbs1 = new SharedBoardSmsWrapper();
        sbs1.setSource("1");
        source.add(sbs1);

        SharedBoardSmsWrapper sbs2 = new SharedBoardSmsWrapper();
        sbs2.setSource("2");
        source.add(sbs2);

        List<BlackNameListModel> blackNameList = new ArrayList<BlackNameListModel>();

        BlackNameListModel bnl1 = new BlackNameListModel();
        bnl1.setSource("1");
        blackNameList.add(bnl1);

        testCollection.screenBlackNameList(source, blackNameList);
//        testCollection.screenBlackNameList1(source, blackNameList);

        for (SharedBoardSmsWrapper tmp : source) {
            System.out.println(tmp.getSource());
        }
    }

    private void screenBlackNameList(List<SharedBoardSmsWrapper> source, List<BlackNameListModel> blackNameList) {
        for (SharedBoardSmsWrapper tmpSharedBoardSmsWrapper : source) {
            for (BlackNameListModel tmpBlackNameListModel : blackNameList) {
                if (tmpSharedBoardSmsWrapper.getSource().equals(tmpBlackNameListModel.getSource())) {
                    source.remove(tmpSharedBoardSmsWrapper);
                    break;
                }
            }
        }
    }

    private void screenBlackNameList1(List<SharedBoardSmsWrapper> source, List<BlackNameListModel> blackNameList) {
        Iterator<SharedBoardSmsWrapper> sourceIt = source.iterator();

        while (sourceIt.hasNext()) {
            SharedBoardSmsWrapper tmpSharedBoardSmsWrapper = sourceIt.next();
            Iterator<BlackNameListModel> blackNameListModelIt = blackNameList.iterator();
            while (blackNameListModelIt.hasNext()) {
                BlackNameListModel tmpBlackNameListModel = blackNameListModelIt.next();

                if (tmpSharedBoardSmsWrapper.getSource().equals(tmpBlackNameListModel.getSource())) {
                    sourceIt.remove();
                    break;
                }
            }
        }

    }


}

class SharedBoardSmsWrapper {

    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

class BlackNameListModel {

    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
