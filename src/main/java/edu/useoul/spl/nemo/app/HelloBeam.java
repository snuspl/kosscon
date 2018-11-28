package edu.useoul.spl.nemo.app;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.values.PCollection;
import org.apache.nemo.compiler.frontend.beam.NemoPipelineOptions;
import org.apache.nemo.compiler.frontend.beam.NemoPipelineRunner;
import org.apache.nemo.examples.beam.GenericSourceSink;

import java.nio.file.Paths;

public class HelloBeam {
  public static void main(final String[] args) {
    final String workingDir = System.getProperty("user.dir");
    final String inputFilePath = Paths.get(workingDir, "resources", "test_input_hello").toString();
    final String outputFilePath = Paths.get(workingDir, "results", "test_output_hello").toString();
    final PipelineOptions options = PipelineOptionsFactory.create().as(NemoPipelineOptions.class);
    options.setRunner(NemoPipelineRunner.class);
    options.setJobName("HelloBeam");

    final Pipeline p = Pipeline.create(options);
    final PCollection<String> result = GenericSourceSink.read(p, inputFilePath);
    GenericSourceSink.write(result, outputFilePath);
    p.run();
  }
}
