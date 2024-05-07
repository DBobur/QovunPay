package org.example.service;

import org.example.model.Organization;
import org.example.repository.OrganizationRepository;
import org.example.repository.UserRepository;

public class OrganizationService extends BaseService<Organization, OrganizationRepository> {
    private static final OrganizationService organizationService = new OrganizationService();
    private OrganizationService() {
        super(new OrganizationRepository());
    }

    public static OrganizationService getInstance(){
        return organizationService;
    }

    @Override
    protected boolean checking(Organization organization) {
        return false;
    }
}
