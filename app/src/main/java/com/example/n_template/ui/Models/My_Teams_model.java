package com.example.n_template.ui.Models;

public class My_Teams_model {

    String tneam, status;

    public  My_Teams_model(){}

    public My_Teams_model(String tneam, String status)
    {
        this.tneam=tneam;
        this.status=status;
    }

    public String getTneam() {
        return tneam;
    }

    public void setTneam(String tneam) {
        this.tneam = tneam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
