package edu.useoul.spl.nemo.pass;

import org.apache.nemo.common.dag.DAG;
import org.apache.nemo.common.ir.edge.IREdge;
import org.apache.nemo.common.ir.edge.executionproperty.DataFlowProperty;
import org.apache.nemo.common.ir.edge.executionproperty.DataStoreProperty;
import org.apache.nemo.common.ir.vertex.IRVertex;
import org.apache.nemo.compiler.optimizer.pass.compiletime.annotating.Annotates;
import org.apache.nemo.compiler.optimizer.pass.compiletime.annotating.AnnotatingPass;

@Annotates({DataFlowProperty.class, DataStoreProperty.class})
public final class SmallScalePass extends AnnotatingPass {
  public SmallScalePass() {
    super(SmallScalePass.class);
  }

  @Override
  public DAG<IRVertex, IREdge> apply(final DAG<IRVertex, IREdge> dag) {
    dag.topologicalDo(vertex ->
      dag.getIncomingEdgesOf(vertex).forEach(edge -> {
        edge.setProperty(DataFlowProperty.of(DataFlowProperty.Value.Push));
        edge.setProperty(DataStoreProperty.of(DataStoreProperty.Value.MemoryStore));
      })
    );
    return dag;
  }
}
