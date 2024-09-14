package org.example.branch;

import java.util.List;

public class BranchService {

    private BranchRepository branchRepository;

    public void add(BranchEntity branch){
        branchRepository.add(branch);
    }

    public void remove(int id){
        branchRepository.remove(id);
    }


    public BranchEntity findById(int id){
        return  branchRepository.findById(id);
    }

    public void update(BranchEntity object, int id) {
        branchRepository.update(object, id);
    }

    public List<BranchEntity> findAll() {
        return  branchRepository.findAll();
    }
}
