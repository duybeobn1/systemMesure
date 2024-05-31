import grpc
from concurrent import futures
import logging
import park_pb2
import park_pb2_grpc
import subprocess

# Configure logging
logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

class CarParkServicer(park_pb2_grpc.CarParkServiceServicer):
    def ProcessCommand(self, request, context):
        try:
            command = request.command
            logger.info(f"Processing command: {command}")

            script_map = {
                "start": r"d:\Stage Air 2024\spring\python-server\AutoExtract+Behavior\part1.py",
                "read": r"d:\Stage Air 2024\spring\python-server\AutoExtract+Behavior\part2.py",
            }

            script = script_map.get(command)
            if not script:
                raise ValueError("Invalid command")

            logger.info(f"Executing script: {script}")

            # Use subprocess.Popen to capture stdout and stderr in real-time
            process = subprocess.Popen(
                ["python", "-u", script],
                stdout=subprocess.PIPE,
                stderr=subprocess.PIPE,
                text=True
            )

            stdout, stderr = process.communicate()

            logger.info(f"Script stdout: {stdout}")
            logger.error(f"Script stderr: {stderr}")

            if process.returncode != 0:
                raise RuntimeError(f"Script error: {stderr}")

            return park_pb2.CommandResponse(result=stdout.strip())

        except Exception as e:
            logger.error(f"Error processing command: {e}")
            context.set_details(str(e))
            context.set_code(grpc.StatusCode.INTERNAL)
            return park_pb2.CommandResponse(result="Error occurred")

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    park_pb2_grpc.add_CarParkServiceServicer_to_server(CarParkServicer(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
    logger.info("gRPC server started on port 50051.")
    server.wait_for_termination()

if __name__ == '__main__':
    serve()
