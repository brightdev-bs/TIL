class TestCase:
    def __init__(self, name):
        self.name=name
    def run(self, result):
        result.testStarted()
        self.setUp()
        try:
            method = getattr(self, self.name);
            method()
        except:
            result.testFailed()
        self.tearDown()
    def setUp(self):
        pass
    def tearDown(self):
        pass
class WasRun(TestCase):
    def testMethod(self):
        self.log= self.log + "testMethod "
    def setUp(self):
        self.log = "setUp "
    def tearDown(self):
        self.log = self.log + "tearDown "
    def testBrokenMethod(self):
        raise Exception
class TestCaseTest(TestCase) :
    def setUp(self):
        self.result = TestResult()
    def testTemplateMethod(self):
        test = WasRun("testMethod")
        test.run(self.result)
        assert("setUp testMethod tearDown " == test.log)
    def testResult(self):
        test = WasRun("testMethod")
        test.run(self.result)
        assert("1 run, 0 failed" == self.result.summary())
    def testFailedResult(self):
        test = WasRun("testBrokenMethod")
        test.run(self.result)
        assert("1 run, 1 failed" == self.result.summary())
    def testFailedResultFormatting(self):
        self.result.testStarted()
        self.result.testFailed()
        assert("1 run, 1 failed" == self.result.summary())
    def testSuite(self):
        suite = TestSuite()
        suite.add(WasRun("testMethod"))
        suite.add(WasRun("testBrokenMethod"))
        suite.run(self.result)
        assert ("2 run, 1 failed" == self.result.summary())

class TestResult:
    def __init__(self):
        self.runCount = 0
        self.failureCount = 0
    def testFailed(self):
        self.failureCount= self.failureCount + 1
    def testStarted(self):
        self.runCount= self.runCount + 1
    def summary(self):
        return "%d run, %d failed" % (self.runCount, self.failureCount)

class TestSuite:
    def __init__(self):
        self.tests = []
    def add(self, test):
        self.tests.append(test)
    def run(self, result):
        for test in self.tests:
            test.run(result)

suite= TestSuite()
suite.add(TestCaseTest("testTemplateMethod"))
suite.add(TestCaseTest("testResult"))
suite.add(TestCaseTest("testFailedResultFormatting"))
suite.add(TestCaseTest("testFailedResult"))
suite.add(TestCaseTest("testSuite"))
result = TestResult()
suite.run(result)
print(result.summary())

