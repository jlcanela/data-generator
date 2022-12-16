import org.apache.log4j.Logger;

object DataGeneratorCli {

    //val log = Logger.getLogger(DataGeneratorCli.getClass().getName())

    def main(args: Array[String]) = args match {
        case Array("generate", path) => DataGenerator.generate(path, 1000)
        case _ => usage
    }

    def usage = println("to generate data\n\t./mill datagenerator.standalone.run generate data/campaigns")
}
