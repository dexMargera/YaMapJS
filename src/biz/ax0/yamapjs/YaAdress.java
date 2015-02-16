package biz.ax0.yamapjs;

/**
 * Created by ivan on 09.12.14.
 */
public class YaAdress {

    private String addressLine;
    private String administrativeAreaName;
    private String subAdministrativeAreaName;
    private String thoroughfareName;
    private String fullAdress;
    private boolean allOk;
    private boolean posOk;

    public String getFullAdress() {
        return fullAdress;
    }

    public void setFullAdress(String fullAdress) {
        this.fullAdress = fullAdress;
    }


    public boolean isPosOk() {
        return posOk;
    }

    public void setPosOk(boolean posOk) {
        this.posOk = posOk;
    }


    public boolean isAllOk() {
        return allOk;
    }

    public void setAllOk(boolean allOk) {
        this.allOk = allOk;
    }


    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    private String pos;

    public String getPremiseNumber() {
        return premiseNumber;
    }

    public void setPremiseNumber(String premiseNumber) {
        this.premiseNumber = premiseNumber;
    }

    private String premiseNumber;

    public String getThoroughfareName() {
        return thoroughfareName;
    }

    public void setThoroughfareName(String thoroughfareName) {
        this.thoroughfareName = thoroughfareName;
    }

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    private String localityName;

    public String getSubAdministrativeAreaName() {
        return subAdministrativeAreaName;
    }

    public void setSubAdministrativeAreaName(String subAdministrativeAreaName) {
        this.subAdministrativeAreaName = subAdministrativeAreaName;
    }

    public String getAdministrativeAreaName() {
        return administrativeAreaName;
    }

    public void setAdministrativeAreaName(String administrativeAreaName) {
        this.administrativeAreaName = administrativeAreaName;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }


    @Override
    public String toString() {
        return "fullAdress: " + fullAdress +
                "\naddressLine: " + addressLine +
                "\nadministrativeAreaName: " + administrativeAreaName +
                "\nsubAdministrativeAreaName: " + subAdministrativeAreaName +
                "\nlocalityName: " + localityName +
                "\nthoroughfareName: " + thoroughfareName +
                "\npremiseNumber: " + premiseNumber +
                "\npos: " + pos +
                "\nAll adress strings found: " + allOk +
                "\nPOS parsed: " + posOk
                ;
    }


}
