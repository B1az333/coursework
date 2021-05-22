package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.Worker;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface WorkerService {
    List<Worker> workerList();

    Worker saveWorker(Worker newWorker);
    Worker getWorker(@PathVariable long sid);
    String deleteWorker(@PathVariable long id);
    String deleteWorkerByClient(@PathVariable long id);
}