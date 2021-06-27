#include <iostream>
#include <string>

using namespace std;

string str;

int main(void) {
	cin >> str;
	string tmp = "";
	int result = 0;
	bool isMinus = false;
	
	// String에서는 '\0' 이 붙지 않는다. 따라서 <=  
	for(int i = 0; i <= str.size(); i++) {
		if(str[i] == '-' || str[i] == '+' || i == str.size()) {
			if(isMinus) {
				result -= stoi(tmp);
				tmp = "";
			} else {
				result += stoi(tmp);
				tmp = "";
			}
		} else{
			tmp += str[i];
		}

		if(str[i] == '-') {
			isMinus = true;
		}
	}
	
	cout << result;
}
