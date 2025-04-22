import sys
from bs4 import BeautifulSoup
from collections import defaultdict


def extract_wrimsv2_dependencies(html_content):
    # Parse the HTML content
    soup = BeautifulSoup(html_content, 'html.parser')

    # Find all rows in the HTML
    rows = soup.find_all('tr')

    dependencies = defaultdict(set)

    # Process each row
    for row in rows[1:]:
        # Extract package name
        cols = row.find_all('td')
        if cols:
            package_name = cols[0].text.strip()

            if package_name.startswith('wrimsv2.') or package_name.startswith('wrimsv2_plugin.'):
                third_level_package = '.'.join(package_name.split('.')[:2])

                # Extract dependencies
                package_dependencies = cols[1].text.strip().split(', ')

                # Filter dependencies to keep only those starting with "wrimsv2."
                filtered_dependencies = [dep for dep in package_dependencies if (dep.startswith('wrimsv2.') or dep.startswith('wrimsv2_plugin.'))]

                # Map the package name to its filtered dependencies
                dependencies[third_level_package].update(filtered_dependencies)

    return dependencies

def main():
    with open(sys.argv[1], 'r') as file:
        # Read the HTML content from the file
        html_content = file.read()
    # Extract dependencies
    wrimsv2_dependencies = extract_wrimsv2_dependencies(html_content)

    # Print the results
    for package, deps in wrimsv2_dependencies.items():
        print(f"{package}:")
        for dep in deps:
            print(f"  - {dep}")

    # write the results to file
    splitter = "\\"
    path = sys.argv[1].split(splitter)
    if (len(path) < 2):
        path = sys.argv[1].split("/")
        splitter = "/"

    result = ""
    pathname = ""

    for pathval in path[:-1]:
        pathname += pathval
        pathname += splitter

    with open(pathname + "dependencies.txt", 'w') as file:
        for package, deps in wrimsv2_dependencies.items():
            result += f"\n{package}:"
            for dep in deps:
                result += f"\n  - {dep}"
        file.write(result)

if __name__ == "__main__":
    # This block is executed when the script is run directly
    main()