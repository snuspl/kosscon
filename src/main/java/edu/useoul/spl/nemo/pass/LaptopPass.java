package edu.useoul.spl.nemo.pass;

import org.apache.nemo.common.dag.DAG;
import org.apache.nemo.common.ir.edge.IREdge;
import org.apache.nemo.common.ir.edge.executionproperty.CompressionProperty;
import org.apache.nemo.common.ir.edge.executionproperty.DataStoreProperty;
import org.apache.nemo.common.ir.vertex.IRVertex;
import org.apache.nemo.compiler.optimizer.pass.compiletime.annotating.Annotates;
import org.apache.nemo.compiler.optimizer.pass.compiletime.annotating.AnnotatingPass;

@Annotates({CompressionProperty.class, DataStoreProperty.class})
public final class LaptopPass extends AnnotatingPass {
  public LaptopPass() {
    super(LaptopPass.class);
  }

  @Override
  public DAG<IRVertex, IREdge> apply(final DAG<IRVertex, IREdge> dag) {
    dag.topologicalDo(vertex ->
      dag.getIncomingEdgesOf(vertex).forEach(edge -> {
        edge.setProperty(CompressionProperty.of(CompressionProperty.Value.None));
        edge.setProperty(DataStoreProperty.of(DataStoreProperty.Value.MemoryStore));
      })
    );
    return dag;
  }
}
