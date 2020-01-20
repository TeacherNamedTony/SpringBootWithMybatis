package cn.am.bean;

import java.util.Objects;

public class Apply {

    private String applyid;
    private String project;
    private String applyername;
    private String softwarename;
    private String applydate;
    private String applyertel;
    private String grantuser;
    private String grantuserperson;
    private String grantuserpersontel;
    private String grantbegindate;
    private String grantenddate;
    private String servertype;
    private String serveros;
    private String serverip;
    private String deploymenttype;
    private String granttype;
    private String machinenum;
    private String productversion;
    private String grantfiletype;
    private String usernum;
    private String controlnum;
    private String computenum;
    private String shopinstancenum;
    private String shopappnum;
    private String desktopinstancenum;
    private String desktopcon;
    private String applynote;

    public String getApplyid() {
        return applyid;
    }

    public void setApplyid(String applyid) {
        this.applyid = applyid;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getApplyername() {
        return applyername;
    }

    public void setApplyername(String applyername) {
        this.applyername = applyername;
    }

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }

    public String getApplydate() {
        return applydate;
    }

    public void setApplydate(String applydate) {
        this.applydate = applydate;
    }

    public String getApplyertel() {
        return applyertel;
    }

    public void setApplyertel(String applyertel) {
        this.applyertel = applyertel;
    }

    public String getGrantuser() {
        return grantuser;
    }

    public void setGrantuser(String grantuser) {
        this.grantuser = grantuser;
    }

    public String getGrantuserperson() {
        return grantuserperson;
    }

    public void setGrantuserperson(String grantuserperson) {
        this.grantuserperson = grantuserperson;
    }

    public String getGrantuserpersontel() {
        return grantuserpersontel;
    }

    public void setGrantuserpersontel(String grantuserpersontel) {
        this.grantuserpersontel = grantuserpersontel;
    }

    public String getGrantbegindate() {
        return grantbegindate;
    }

    public void setGrantbegindate(String grantbegindate) {
        this.grantbegindate = grantbegindate;
    }

    public String getGrantenddate() {
        return grantenddate;
    }

    public void setGrantenddate(String grantenddate) {
        this.grantenddate = grantenddate;
    }

    public String getServertype() {
        return servertype;
    }

    public void setServertype(String servertype) {
        this.servertype = servertype;
    }

    public String getServeros() {
        return serveros;
    }

    public void setServeros(String serveros) {
        this.serveros = serveros;
    }

    public String getServerip() {
        return serverip;
    }

    public void setServerip(String serverip) {
        this.serverip = serverip;
    }

    public String getDeploymenttype() {
        return deploymenttype;
    }

    public void setDeploymenttype(String deploymenttype) {
        this.deploymenttype = deploymenttype;
    }

    public String getGranttype() {
        return granttype;
    }

    public void setGranttype(String granttype) {
        this.granttype = granttype;
    }

    public String getMachinenum() {
        return machinenum;
    }

    public void setMachinenum(String machinenum) {
        this.machinenum = machinenum;
    }

    public String getProductversion() {
        return productversion;
    }

    public void setProductversion(String productversion) {
        this.productversion = productversion;
    }

    public String getGrantfiletype() {
        return grantfiletype;
    }

    public void setGrantfiletype(String grantfiletype) {
        this.grantfiletype = grantfiletype;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getControlnum() {
        return controlnum;
    }

    public void setControlnum(String controlnum) {
        this.controlnum = controlnum;
    }

    public String getComputenum() {
        return computenum;
    }

    public void setComputenum(String computenum) {
        this.computenum = computenum;
    }

    public String getShopinstancenum() {
        return shopinstancenum;
    }

    public void setShopinstancenum(String shopinstancenum) {
        this.shopinstancenum = shopinstancenum;
    }

    public String getShopappnum() {
        return shopappnum;
    }

    public void setShopappnum(String shopappnum) {
        this.shopappnum = shopappnum;
    }

    public String getDesktopinstancenum() {
        return desktopinstancenum;
    }

    public void setDesktopinstancenum(String desktopinstancenum) {
        this.desktopinstancenum = desktopinstancenum;
    }

    public String getDesktopcon() {
        return desktopcon;
    }

    public void setDesktopcon(String desktopcon) {
        this.desktopcon = desktopcon;
    }

    public String getApplynote() {
        return applynote;
    }

    public void setApplynote(String applynote) {
        this.applynote = applynote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Apply apply = (Apply) o;
        return Objects.equals(applyid, apply.applyid) &&
                Objects.equals(project, apply.project) &&
                Objects.equals(applyername, apply.applyername) &&
                Objects.equals(softwarename, apply.softwarename) &&
                Objects.equals(applydate, apply.applydate) &&
                Objects.equals(applyertel, apply.applyertel) &&
                Objects.equals(grantuser, apply.grantuser) &&
                Objects.equals(grantuserperson, apply.grantuserperson) &&
                Objects.equals(grantuserpersontel, apply.grantuserpersontel) &&
                Objects.equals(grantbegindate, apply.grantbegindate) &&
                Objects.equals(grantenddate, apply.grantenddate) &&
                Objects.equals(servertype, apply.servertype) &&
                Objects.equals(serveros, apply.serveros) &&
                Objects.equals(serverip, apply.serverip) &&
                Objects.equals(deploymenttype, apply.deploymenttype) &&
                Objects.equals(granttype, apply.granttype) &&
                Objects.equals(machinenum, apply.machinenum) &&
                Objects.equals(productversion, apply.productversion) &&
                Objects.equals(grantfiletype, apply.grantfiletype) &&
                Objects.equals(usernum, apply.usernum) &&
                Objects.equals(controlnum, apply.controlnum) &&
                Objects.equals(computenum, apply.computenum) &&
                Objects.equals(shopinstancenum, apply.shopinstancenum) &&
                Objects.equals(shopappnum, apply.shopappnum) &&
                Objects.equals(desktopinstancenum, apply.desktopinstancenum) &&
                Objects.equals(desktopcon, apply.desktopcon) &&
                Objects.equals(applynote, apply.applynote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applyid, project, applyername, softwarename, applydate, applyertel, grantuser, grantuserperson, grantuserpersontel, grantbegindate, grantenddate, servertype, serveros, serverip, deploymenttype, granttype, machinenum, productversion, grantfiletype, usernum, controlnum, computenum, shopinstancenum, shopappnum, desktopinstancenum, desktopcon, applynote);
    }

    @Override
    public String toString() {
        return "Apply{" +
                "applyid='" + applyid + '\'' +
                ", project='" + project + '\'' +
                ", applyername='" + applyername + '\'' +
                ", softwarename='" + softwarename + '\'' +
                ", applydate='" + applydate + '\'' +
                ", applyertel='" + applyertel + '\'' +
                ", grantuser='" + grantuser + '\'' +
                ", grantuserperson='" + grantuserperson + '\'' +
                ", grantuserpersontel='" + grantuserpersontel + '\'' +
                ", grantbegindate='" + grantbegindate + '\'' +
                ", grantenddate='" + grantenddate + '\'' +
                ", servertype='" + servertype + '\'' +
                ", serveros='" + serveros + '\'' +
                ", serverip='" + serverip + '\'' +
                ", deploymenttype='" + deploymenttype + '\'' +
                ", granttype='" + granttype + '\'' +
                ", productversion='" + productversion + '\'' +
                ", grantfiletype='" + grantfiletype + '\'' +
                ", machinenum='" + machinenum + '\'' +
                ", usernum='" + usernum + '\'' +
                ", controlnum='" + controlnum + '\'' +
                ", computenum='" + computenum + '\'' +
                ", shopinstancenum='" + shopinstancenum + '\'' +
                ", shopappnum='" + shopappnum + '\'' +
                ", desktopinstancenum='" + desktopinstancenum + '\'' +
                ", desktopcon='" + desktopcon + '\'' +
                ", applynote='" + applynote + '\'' +
                '}';
    }
}
