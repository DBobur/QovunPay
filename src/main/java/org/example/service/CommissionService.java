package org.example.service;

import org.example.model.Commission;
import org.example.repository.CommissionRepository;
import org.example.repository.MessageRepository;

public class CommissionService extends BaseService<Commission, CommissionRepository>{
    private static final CommissionService commissionService = new CommissionService();
    private CommissionService() {
        super(new CommissionRepository());
    }

    public static CommissionService getInstance(){
        return commissionService;
    }

    @Override
    protected boolean checking(Commission commission) {
        return false;
    }
}
