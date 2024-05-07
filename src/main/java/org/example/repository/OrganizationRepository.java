package org.example.repository;

import org.example.model.model.Organization;

public class OrganizationRepository extends BaseRepository<Organization> {
    {
        path += "organizations.json";
        type = Organization.class;
    }
}
