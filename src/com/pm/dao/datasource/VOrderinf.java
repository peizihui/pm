package com.pm.dao.datasource;

import java.io.Serializable;

public class VOrderinf implements Serializable {
    private VOrderinfId vOrderinfId;

    public VOrderinfId getvOrderinfId() {
        return vOrderinfId;
    }

    public void setvOrderinfId(VOrderinfId vOrderinfId) {
        this.vOrderinfId = vOrderinfId;
    }
}
