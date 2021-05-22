package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.Contract;
import kpi.zabelskyi.csdb.blaze.corp.model.Worker;
import kpi.zabelskyi.csdb.blaze.corp.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Iterator;
import java.util.List;


@Service
public class WorkerServiceImpl implements WorkerService{
    private final WorkerRepository workerRepository;
    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository){
        this.workerRepository=workerRepository;
    }

    @Override
    public List<Worker> workerList() { return workerRepository.findAll(); }

    @Override
    public Worker saveWorker(Worker newWorker) {
        return workerRepository.save(newWorker);
    }

    @Override
    public Worker getWorker(long sid) {
        return workerRepository.findById(sid)
                .orElseThrow();
    }


    @Override
    public String deleteWorker(@PathVariable long sid){
        Worker s = workerRepository.getOne(sid);
        workerRepository.delete(s);
        return "deleted";
    }

    @Override
    public String deleteWorkerByClient(@PathVariable long sid){

        Iterator<Worker> iter = workerRepository.findAll().iterator();

        while(iter.hasNext())
        {
            Worker temp = iter.next();
            if(temp.getIdClient() == sid)
            {
                workerRepository.delete(temp);
            }
        }
        return "deleted";
    }

}