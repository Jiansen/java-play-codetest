package controllers;

import akka.actor.ActorSystem;
import javax.inject.*;
import play.*;
import play.mvc.*;
import java.util.concurrent.Executor;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import scala.concurrent.duration.Duration;
import scala.concurrent.ExecutionContextExecutor;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.libs.Json;
import java.util.*;

public class CustomersController extends Controller
{
  private final ActorSystem actorSystem;
  private final ExecutionContextExecutor exec;

  @Inject
  public CustomersController(ActorSystem actorSystem, ExecutionContextExecutor exec) {
   this.actorSystem = actorSystem;
   this.exec = exec;
  }

  public CompletionStage<Result> sortCustomersList() {
      return getFutureResult(0, TimeUnit.SECONDS).thenApplyAsync(Results::ok, exec);
  }

  private CompletionStage<JsonNode> getFutureResult(long time, TimeUnit timeUnit) {
      final Http.Context ctx = ctx();
      CompletableFuture<JsonNode> future = new CompletableFuture<>();
      actorSystem.scheduler().scheduleOnce(
          Duration.create(time, timeUnit),
          () -> future.complete( sortList(ctx) ),
          exec
      );
      return future;
  }

  private JsonNode sortList(Http.Context ctx) {
      JsonNode jsonNode = ctx.request().body().asJson();

      List<Customer> list = new ArrayList();
      jsonNode.forEach(json -> {
          list.add(Json.fromJson(json, Customer.class));
      });

      list.sort((c1, c2) -> {
          return c1.getDuetime().compareTo(c2.getDuetime());
      });
      return Json.toJson(list);
  }
}
